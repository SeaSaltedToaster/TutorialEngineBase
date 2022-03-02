#version 140

in vec3 position;

uniform mat4 transformationMatrix;
uniform mat4 viewMatrix;

void main(void)	{

	vec4 worldPosition = transformationMatrix * vec4(position, 1.0f);
	gl_Position = worldPosition * viewMatrix;
}
