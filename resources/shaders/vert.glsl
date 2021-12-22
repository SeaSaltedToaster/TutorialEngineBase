#version 140

in vec2 position;

uniform vec2 translation;

void main(void)	{

	gl_Position = vec4(position + translation, 0.0, 1.0);
	
}
