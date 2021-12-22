package renderer;

import renderer.shader.Shader;
import renderer.shader.uniforms.UniformVec2;
import renderer.shader.uniforms.UniformVec3;

public class SimpleShader extends Shader {
	
	private static final String vertexShader = "/shaders/vert.glsl";
	private static final String fragmentShader = "/shaders/frag.glsl";
	
	protected UniformVec3 modelColor = new UniformVec3("color");
	protected UniformVec2 translation = new UniformVec2("translation");

	public SimpleShader() {
		super(vertexShader, fragmentShader);
		super.locateUniform(modelColor);
		super.locateUniform(translation);
	}
	
	public UniformVec2 getTranslation() {
		return translation;
	}

	public UniformVec3 getModelColor() {
		return modelColor;
	}

}
