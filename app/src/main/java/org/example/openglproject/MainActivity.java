package org.example.openglproject;
import android.util.Log;
import android.app.Activity;
import android.content.Context;
import android.opengl.EGLConfig;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import javax.microedition.khronos.opengles.GL10;

public class MainActivity extends Activity {

    private GLSurfaceView gLView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d( "HelloOpenGLES10", "in onCreate()" );
        // Create a GLSurfaceView instance and set it
        // as the ContentView for this Activity.
        gLView = new MyGLSurfaceView(this);
        setContentView(gLView);
    }
}
class MyGLSurfaceView extends GLSurfaceView {

    private final MyGLRenderer renderer;

    public MyGLSurfaceView(Context context){
        super(context);

        // Create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2);
        //setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

        renderer = new MyGLRenderer();

        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(renderer);
    }
}

class MyGLRenderer implements GLSurfaceView.Renderer {
   // private final Context context;
    //private final Triangle triangle = new Triangle();
    Triangle mTriangle;


    public static int loadShader(int type, String shaderCode){

        // create a vertex shader type (GLES20.GL_VERTEX_SHADER)
        // or a fragment shader type (GLES20.GL_FRAGMENT_SHADER)
        int shader = GLES20.glCreateShader(type);

        // add the source code to the shader and compile it
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);

        return shader;
    }


    //public void onSurfaceCreated(GL10 unused, EGLConfig config) {
        // Set the background frame color
       // GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    //}

    public void onDrawFrame(GL10 unused) {
        // Redraw background color
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        mTriangle.draw();

        //Triangle mTriangle;

        //triangle.draw(gl);
    }
    //MyGLRenderer(Context context) {
      //  this.context = context;
    //}
    //MyglrendererloadTexture(gl, context);
    @Override
    public void onSurfaceCreated(GL10 gl, javax.microedition.khronos.egl.EGLConfig config) {
        GLES20.glClearColor(255.0f, 0.0f, 0.0f, 1.0f);
        // initialize a triangle
        mTriangle = new Triangle();

    }

    public void onSurfaceChanged(GL10 unused, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
    }
}



