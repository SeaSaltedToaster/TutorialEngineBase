package renderer;

import renderer.shader.Shader;

public class SimpleShader extends Shader {
	
	private static final String vertexShader = "/shaders/vert.glsl";
	private static final String fragmentShader = "/shaders/frag.glsl";

	public SimpleShader() {
		super(vertexShader, fragmentShader);
	}

}
