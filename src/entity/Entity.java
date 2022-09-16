package entity;

import java.util.ArrayList;
import java.util.List;

import utilities.Vector3f;

public class Entity {
	
	private Transform transform;
	private List<Component> components;

	public Entity() {
		this.transform = new Transform(new Vector3f(0,0,0), new Vector3f(0,0,0), new Vector3f(1,1,1));
		this.components = new ArrayList<Component>();
	}
	
	public void addComponent(Component component) {
		this.components.add(component);
	}
	
	public Component getComponent(String type) {
		for(Component component : components) {
			if(component.getType() == type)
				return component;
		}
		return null;
	}

	public Transform getTransform() {
		return transform;
	}

	public void setTransform(Transform transform) {
		this.transform = transform;
	}

	public List<Component> getComponents() {
		return components;
	}

	public void setComponents(List<Component> components) {
		this.components = components;
	}
	
}
