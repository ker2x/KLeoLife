import kotlinx.html.div
import kotlinx.html.dom.append
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.html.canvas
import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLCanvasElement


fun main() {
    window.onload = { setup() }
}

// setup function runs once
fun setup() {
    console.log("entering setup")
    val gfx = GraphicData(window.innerWidth, window.innerHeight)

    // create canvas
    console.log("creating canvas")
    gfx.canvas = document.createElement("canvas") as HTMLCanvasElement
    gfx.canvas.width = gfx.width
    gfx.canvas.height = gfx.height
    document.body!!.append(gfx.canvas)

//    gfx.canvas = document.getElementById("canvas") as HTMLCanvasElement
    gfx.ctx = gfx.canvas.getContext("2d") as CanvasRenderingContext2D

    console.log("canvas created")
    console.log("canvas width: ${gfx.width}")
    console.log("canvas height: ${gfx.height}")
    // request animation frame
    window.requestAnimationFrame { draw(gfx) }
}

// draw function runs continuously at browser refresh rate
fun draw(gfx: GraphicData) {
    // clear canvas
    gfx.ctx.beginPath()
    gfx.ctx.fillStyle = "red"
    gfx.ctx.rect(0.0, 0.0, 100,100)
    gfx.ctx.fill()
    // request next draw loop
    window.requestAnimationFrame { draw(gfx) }
}