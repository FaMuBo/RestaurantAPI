package com.exampleFinartz.demo.controllers;

import com.exampleFinartz.demo.models.dto.UserDTO;
import com.exampleFinartz.demo.models.request.create.UserCreateRequest;
import com.exampleFinartz.demo.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

;

@RestController
@RequestMapping("user")
public class UserController {

    private final Integer ACCESS_TOKEN_MINUTE = 10;
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        return new ResponseEntity(userService.getUser(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserCreateRequest userCreateRequest) {
        return new ResponseEntity(userService.createUser(userCreateRequest), HttpStatus.CREATED);
    }

//    @GetMapping("refresh-token")
//    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
//        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
//            try {
//                String refreshToken = authorizationHeader.substring("Bearer ".length());
//                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
//                JWTVerifier verifier = JWT.require(algorithm).build();
//                DecodedJWT decodedJWT = verifier.verify(refreshToken);
//                String email = decodedJWT.getSubject();
//                UserDto user = userService.getUser(email);
//                String accessToken = JWT.create()
//                        .withSubject(user.getEmail())
//                        .withExpiresAt(new Date(System.currentTimeMillis() + ACCESS_TOKEN_MINUTE * 60 * 1000))
//                        .withIssuer(request.getRequestURL().toString())
//                        .withClaim("roles", user.getRoles().stream().map(Role::name).collect(Collectors.toList()))
//                        .sign(algorithm);
//
//                Map<String,String> tokens = new HashMap<>();
//                tokens.put("access-token", accessToken);
//                tokens.put("refresh-token", refreshToken);
//
//                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
//            }catch(Exception exception){
//                response.setHeader("error", exception.getMessage());
//                response.setStatus(FORBIDDEN.value());
//                //response.sendError(FORBIDDEN.value());
//                Map<String,String> error = new HashMap<>();
//                error.put("error_msg", exception.getMessage());
//                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//                new ObjectMapper().writeValue(response.getOutputStream(), error);
//            }
//        }else {
//            throw new RuntimeException("Refresh token is missing");
//        }
//
//    }

}