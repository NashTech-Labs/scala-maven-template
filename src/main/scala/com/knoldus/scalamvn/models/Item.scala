package com.knoldus.scalamvn.models

case class Code(itemCodes: List[String])

case class Item(id: Long,
                name: String,
                code: Code)
