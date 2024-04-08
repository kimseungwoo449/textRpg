package textRpg;

import java.util.Random;

public class ItemWeapon extends Item implements Equipable{
	private Random ran = new Random();

	private int grade;
	private int extraPower;
	
	public ItemWeapon(int grade) {
		setNameAndPrice(grade);
	}
	
	@Override
	public void fucntion(Unit target) {
		Hero hero = (Hero)target;
		if(!super.isEquiped()) {
			hero.setExtraPower(extraPower);
			super.setIsEquiped();
			super.setEquipedHero(hero);
		}else {
			hero.setExtraPower(0);
			super.setIsEquiped();
			super.setEquipedHero(hero);
		}
	}
	
	@Override
	public void setNameAndPrice(int grade) {
		if(grade<1||grade>3)
			return;
		
		if(grade==1) {
			super.setName("돌 검");
			super.setPrice(500);
			this.extraPower = ran.nextInt(5)+15;
		}else if(grade==2) {
			super.setName("철 검");
			super.setPrice(700);
			this.extraPower = ran.nextInt(5)+20;
		}else if(grade==3) {
			super.setName("다이아몬드 검");
			super.setPrice(1000);
			this.extraPower = ran.nextInt(5)+30;
		}
	}
	
	public int getGrade() {
		return this.grade;
	}
	
	public int getExtraPower() {
		return this.extraPower;
	}
	
	@Override
	public String toString() {
		String info = String.format("%s 공격력 : %d", super.toString(),this.extraPower);
		return info;
	}
}
