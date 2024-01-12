package com.simon.application.form;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults (level = AccessLevel.PRIVATE)
public class CarriageForm {

    Long id;
    Short number;
    Long carriageTypeId;
    Long trainId;
}
