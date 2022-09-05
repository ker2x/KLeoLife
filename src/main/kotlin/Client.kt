import kotlinx.browser.document
import kotlinx.browser.window
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

    gfx.ctx = gfx.canvas.getContext("2d") as CanvasRenderingContext2D

    // add window resize listener
    window.onresize = { resize(gfx) }

    // request animation frame
    window.requestAnimationFrame { draw(gfx) }
}

// draw function runs continuously at browser refresh rate
fun draw(gfx: GraphicData) {
    // clear canvas
    gfx.ctx.beginPath()
    gfx.ctx.fillStyle = "black"
    gfx.ctx.rect(0.0, 0.0, gfx.width,gfx.height)
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