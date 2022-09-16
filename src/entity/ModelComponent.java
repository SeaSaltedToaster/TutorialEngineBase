package entity;

import models.Vao;

public class ModelComponent extends Component {

	private Vao vao;
	
	public ModelComponent(Vao vao) {
		this.vao = vao;
	}

	@Override
	public void update() {
		
	}

	@Override
	public String getType() {
		return "Model";
	}

	public Vao getVao() {
		return vao;
	}

	public void setVao(Vao vao) {
		this.vao = vao;
	}

}
