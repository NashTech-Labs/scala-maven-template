package com.knoldus.scalamvn.config

import com.softwaremill.macwire.wire

trait ServerConfig extends AkkaConfig {

  lazy val server = wire[Server]
}
