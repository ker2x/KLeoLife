import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLCanvasElement


fun main() {
    window.onload = { setup() }
}

// setup function runs once
fun setup() {

    // Setup application class
    val gfx = GraphicData(window.innerWidth, window.innerHeight)

    // body style
    document.body!!.style.backgroundColor = "grey"
    document.body!!.style.margin = "0px"
    document.body!!.style.padding = "0px"
    document.body!!.style.overflowX = "hidden"
    document.body!!.style.overflowY = "hidden"

    // create & append canvas
    gfx.canvas = document.createElement("canvas") as HTMLCanvasElement
    gfx.canvas.width = gfx.width
    gfx.canvas.height = gfx.height
    document.body!!.append(gfx.canvas)

    // get canvas context
    gfx.ctx = gfx.canvas.getContext("2d") as CanvasRenderingContext2D

    // add window resize listener
    window.onresize = { resize(gfx) }

    // add mouse listener on canvas
    gfx.canvas.onclick = { mouseClick(gfx, it.x, it.y) }

    // request animation frame
    window.requestAnimationFrame { draw(gfx) }
}

// draw function runs continuously at browser refresh rate
fun draw(gfx: GraphicData) {
    // clear canvas
    gfx.ctx.beginPath()
    gfx.ctx.fillStyle = "black"
    gfx.ctx.rect(0.0, 0.0, gfx.width.toDouble(),gfx.height.toDouble())
    gfx.ctx.fill()
    // request next draw loop
    window.requestAnimationFrame { draw(gfx) }
}

// resize function runs when window is resized
fun resize(gfx: GraphicData) {
    gfx.width = window.innerWidth
    gfx.height = window.innerHeight
    gfx.canvas.width = gfx.width
    gfx.canvas.height = gfx.height
}

// mouseClick function runs when mouse is clicked on canvas
fun mouseClick(gfx: GraphicData, x: Double, y: Double) {
    console.log("Mouse click on $gfx at $x, $y")
}
