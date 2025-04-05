package com.zem.designpattern.deprecated.state;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeprecatedOrder {

    private String OrderId;
    private String productId;
    private String state;
}
