package kleolife.ui

import kleolife.data.GraphicData
import kotlinx.browser.window

class UIUtils {
    companion object {
        // Resize canvas
        fun resizeCanvas(gfx: GraphicData, width: Int = window.innerWidth, height: Int = window.innerHeight) {
            gfx.width = width
            gfx.height = height
            gfx.canvas.width = gfx.width
            gfx.canvas.height = gfx.height
        }

        // resize canvas to window size, callback for window resize event
        fun resizeCallback(gfx: GraphicData) {
            resizeCanvas(gfx)
        }

        // mouseClick function runs when mouse is clicked on canvas
        fun mouseClickCallback(gfx: GraphicData, x: Double, y: Double) {
            console.log("Mouse click on $gfx at $x, $y")
        }
    }
}