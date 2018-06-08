package com.knoldus.scalamvn

import com.knoldus.scalamvn.config.{ControllerConfig, ServerConfig}

object Application extends App with ServerConfig with ControllerConfig {

  server.bind(routes = routes)

  val message =
    """
      |
      |   _____                                 _    _  _____
      |  / ____|                               | |  | ||  __ \
      | | (___    ___  _ __ __   __ ___  _ __  | |  | || |__) |
      |  \___ \  / _ \| '__|\ \ / // _ \| '__| | |  | ||  ___/
      |  ____) ||  __/| |    \ V /|  __/| |    | |__| || |
      | |_____/  \___||_|     \_/  \___||_|     \____/ |_|
      |
      |
      |
    """.stripMargin

  println(message)
}
