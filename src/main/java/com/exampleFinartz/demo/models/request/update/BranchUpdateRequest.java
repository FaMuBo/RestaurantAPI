package com.exampleFinartz.demo.models.request.update;


import com.exampleFinartz.demo.models.dto.MenuDTO;
import com.exampleFinartz.demo.models.enums.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BranchUpdateRequest {
    private Position position;
    private MenuDTO menu;
}
