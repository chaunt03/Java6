package com.fpoly.lab3.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Students2 {

    @NotBlank(message = "Không để trống email")
    @Email(message = "Không đúng định dạng email")
    String email;

    @NotBlank(message = "Không để trông fullname")
    String fullname;

    @NotNull(message = "Không để trống điểm")
    @PositiveOrZero(message = "Điểm phải lớn hơn hoặc bằng 0")
    @Max(message = "Điểm phải nhỏ hơn hoặc bằng 10", value = 10)
    Double marks;

    @NotNull(message = "Vui lòng chọn giới tính !")
    Boolean gender;

    @NotBlank(message = "Vui lòng chọn quốc tịch !")
    String country;
}
