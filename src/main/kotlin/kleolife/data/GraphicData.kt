package kleolife.data

import org.khronos.webgl.WebGLRenderingContext
import org.w3c.dom.HTMLCanvasElement

data class GraphicData(var width: Int = 500, var height:Int = 500) {
    lateinit var canvas: HTMLCanvasElement
    lateinit var ctx: WebGLRenderingContext

    // default fragment shaders
    // see https://developer.mozilla.org/en-US/docs/Web/API/WebGL_API/Tutorial/Adding_2D_content_to_a_WebGL_context
    val fragmentShaderSource : String = """
        void main() {
          gl_FragColor = vec4(1.0, 1.0, 1.0, 1.0);
        }
    """.trimIndent()

    // default vertex shaders
    // see https://developer.mozilla.org/en-US/docs/Web/API/WebGL_API/Tutorial/Adding_2D_content_to_a_WebGL_context
    val vertexShaderSource : String = """
        attribute vec4 aVertexPosition;
        uniform mat4 uModelViewMatrix;
        uniform mat4 uProjectionMatrix;
        void main() {
          gl_Position = uProjectionMatrix * uModelViewMatrix * aVertexPosition;
        }
    """.trimIndent()
}
