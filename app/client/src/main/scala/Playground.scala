package client

import org.scalajs.dom
import org.scalajs.dom.html
import org.scalajs.dom.html.Canvas

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}
import scala.util.Random

object Playground {
  @JSExport
  def main(args: Array[String]): Unit = println("MAIN()")

  @JSExportTopLevel("Playground")
  def run(): Unit = {
    dom.console.log("RUN()")

    val socket = new dom.WebSocket("ws://localhost:8080")
    socket.onmessage = {
      e: dom.MessageEvent => dom.console.log(e.data.toString)
    }

    val canvas = dom.document.createElement("canvas").asInstanceOf[Canvas]
    canvas.height = 600
    canvas.width = 800
    dom.document.body.appendChild(canvas)
    val ctx = canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]

    var x = 300.0
    var y = 400.0

    ctx.fillRect(x, y, 10, 10)
    dom.window.setInterval(() => {
      ctx.clearRect(0, 0, 800, 600)
      x += (Random.nextDouble() - 0.5) * 5
      y += (Random.nextDouble() - 0.5) * 7
      ctx.fillRect(x, y, 10, 10)
    }, 20)
  }
}
