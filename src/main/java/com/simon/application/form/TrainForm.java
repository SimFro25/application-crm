package com.simon.application.form;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@FieldDefaults (level = AccessLevel.PRIVATE)
public class TrainForm {
    String name;
    Long route;
}
