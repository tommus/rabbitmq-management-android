package co.windly.rabbitmqmanagement.domain.definition;

import androidx.annotation.StringDef;

import static co.windly.rabbitmqmanagement.domain.definition.Tag.ADMINISTRATOR;
import static co.windly.rabbitmqmanagement.domain.definition.Tag.MANAGEMENT;
import static co.windly.rabbitmqmanagement.domain.definition.Tag.MONITORING;
import static co.windly.rabbitmqmanagement.domain.definition.Tag.NONE;
import static co.windly.rabbitmqmanagement.domain.definition.Tag.POLICY_MAKER;

@StringDef({
  ADMINISTRATOR,
  MONITORING,
  POLICY_MAKER,
  MANAGEMENT,
  NONE
})
public @interface Tag {

  String ADMINISTRATOR = "administrator";

  String MONITORING = "monitoring";

  String POLICY_MAKER = "policymaker";

  String MANAGEMENT = "management";

  String NONE = "none";
}
