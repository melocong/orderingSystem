package com.orderingSystem.param;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.orderingSystem.param.SqlQueryParam;

@Getter
@Setter
@ToString
public class DishQueryParam extends SqlQueryParam{
      private String id;
}
