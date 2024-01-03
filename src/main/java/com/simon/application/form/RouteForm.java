package com.simon.application.form;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class RouteForm {

    Long id;
    String name;
    Double distancePrice;
}
