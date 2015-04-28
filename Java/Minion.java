public class Minion{
	int health;
	int attack_damage;
	int magic_resist;
	int armor;
	int damage_type;
	Boolean alive;
	String color;
	public Minion(int health, int attack_damage, int magic_resist, int armor, int damage_type, String color){
		this.health = health;
		this.attack_damage = attack_damage;
		this.magic_resist = magic_resist;
		this.armor = armor;
		this.alive = true;
		this.color = color;
		this.damage_type = damage_type;
	}

	public int getHealth(){
		return health;
	}

	public int getAttackDamage(){
		return this.attack_damage;
	}

	public int getAttackType(){
		return this.damage_type;
	}

	public String getColor(){
		return this.color;
	}

	public void onDamaged(int attack, int type){
		//Type == 1: fisico
		//type == 2: magico
		int final_damage = 0;
		if(type == 1){
			final_damage = attack - this.armor;
		}
		else
			final_damage = attack - this.magic_resist;
		this.health = this.health - final_damage;
		if(this.health <= 0)
			this.onDead();
	}

	public void onDead(){
		alive = false;
	}

	public Boolean isAlive(){
		return this.alive;
	}
}