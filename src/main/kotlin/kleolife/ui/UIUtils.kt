package kleolife.ui

import kleolife.data.GraphicData
import kotlinx.browser.window

class UIUtils {
    companion object {
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

    }
}