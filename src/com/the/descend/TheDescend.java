package com.the.descend;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class TempDescend
{
	public static void main(String[] args)
	{
		TempDescend TD = new TempDescend();
		clear();
		TD.Intro();
		//TD.UpdateStats();
		clear();
		Level1();
		Level2();
	}
 
/*    void UpdateStats(String name)
	{
		try
		{
			FileWriter fw = new FileWriter("D:\\Java\\TheDescend\\Status");
			fw.write("Name : " + name);
			fw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
*/
	
	private void Intro()
	{
		System.out.println("\tYou are a vagabond who is done with petty thievery and wishes to turn over a new leaf.");
		System.out.println("\tHearing rumours from the last town that you put up a residence for a while in, you come to accept the fact that there is a place named the Descend located in a forest.");
		System.out.println("\tConvinced that this was the opportunity you were looking for, you set yourself up for the Descend.");
		System.out.println("\tThe rumours you've heard about it has you convinced that there's something about the Descend that's not normal");
		System.out.println("\tSomething that will change your life.");
		System.out.println("\tYou stand outside the Hole that is the descend and decide that this is your turning point.");
		System.out.println("\tYou'll be able to hold your head up high once you walk out because all the rumours about the Descend were of it's immense riches, and the dead men's belongings along the Descend.");
		System.out.println("\tYou now shall turn over a new leaf, and a new leaf needs a new identity.");
		System.out.println("\tAs you head out, you come to a decision that you want to be named Hunch.");
		System.out.println("\tEnter the tale, HUNCH.");
	}
	
	static private void Level1()
	{
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		Player player = new Player();
		Enemy enemy = new Enemy();
		
		char cont = 'y';
		int choice, enemyDmg, atkpos = 0, enepos  = 0;
		boolean alive = true;
		
		if(player.numBattles < 5)
		{
			while(cont == 'y'|| cont == '1')
			{
				player.numBattles++;
				System.out.println("You encounter an enemy.");
				String currentEnemy = enemy.Name[rand.nextInt(enemy.Name.length)];
				for(int i = 0; i < enemy.Name.length; i++)
				{
					if(currentEnemy.equals(enemy.Name[i]))
					{
						enepos = i;
					}
				}
				System.out.println("It's a " + currentEnemy);
				
				FIGHT:
				while(enemy.BattleHP[enepos] > 0)
				{
					if(player.HP < 0)
					{
						alive = false;
						break;
					}
					System.out.println("What do you choose to do?");
					System.out.println("1. Attack.");
					System.out.println("2. Use Items.");
					System.out.println("3. View status of the Battle.");
					System.out.println("4. Run Away.");
					choice = sc.nextInt();
					switch(choice)
					{
						case 1:
						{
							System.out.println("You attack the enemy for " + player.Atk + " damage.");
							enemy.BattleHP[enepos] = enemy.BattleHP[enepos] - player.Atk;
							enemyDmg = enemy.Atk[enepos][rand.nextInt(enemy.Atk.length)];
							for(int i = 0; i < enemy.Name.length; i++)
							{
								if(enemyDmg == enemy.Atk[enepos][i])
									atkpos = i;
							}
							System.out.println(enemy.Name[enepos] + " executes the attack " + enemy.AtkNames[enepos][atkpos]);
							System.out.println("The enemy does " + enemyDmg + " damage to you.");
							player.HP = player.HP - enemyDmg;
							if(enemy.BattleHP[enepos] < 0)
							{
								enemy.BattleHP[enepos] = 0;
							}
							System.out.println("Your HP : " + player.HP + ", the enemy's HP : " + enemy.BattleHP[enepos]);
							break;
						}
						case 2:
						{
							System.out.println("Which item would you like to use?");
							System.out.println("1. " +  player.potions + " :\t" + player.numOfHealPot);
							int pick = sc.nextInt();
							if (pick == 1)
							{
								player.HP = player.HP + 30;
								player.numOfHealPot--;
							}
							break;
						}
						case 3:
						{
							System.out.println("Your Status : ");
							System.out.println("> Health Points : " + player.HP);
							System.out.println("> Enemy's Health Points : " + enemy.BattleHP[enepos]);
							break;
						}
						case 4:
						{
							int manage = rand.nextInt(enemy.BattleHP.length);
							if(manage < 2)
							{
								System.out.println("You fail in running away.");
							}
							else
							{
								break FIGHT;
							}
							break;
						}
						default:
						{
							System.out.println("What were you thinking? You died!");
							Rest();
							break;
						}
					}
				}
				
				
				if(enemy.BattleHP[enepos] <= 0)
				{
					System.out.println("---------------------------------------------");
					System.out.println("You have defeated the enemy.");
				}
				else if(enemy.BattleHP[enepos] > 0 && alive)
				{
					System.out.println("You've run away from a battle?");
				}
				else
				{
					System.out.println("That must've been a hard battle, nice try.");
					Rest();
				}
				
				replenishEnemy(enepos);
				
				System.out.println("Do you wish to continue down this path, or go back to town?");
				System.out.println("Proceed further? (y/n)");
				cont = sc.next().charAt(0);
			}
			if(cont == 'n'|| cont == '2')
			{
				Surface();
			}
			else
			{
				Surface();
			}
		}
		else
		{
			System.out.println("You reach the first stop in the descend, as you find yourself at a crossroads.");
			System.out.println("There are two different ways to go, left or right?");
			System.out.println("Which one do you pick?");
		}
	}
	
	static private void Level2()
	{
		System.out.println("Level 2 is still under construction.");
		System.out.println("Maybe it'll be released after a few of the items in the to-do list are completed.");
	}
	
	private static void Surface()
	{
		Player player = new Player();
		System.out.println("You are back at the surface, with the smell of the descend departing from your body with each step you take further away from it.");
		System.out.println("Do you wish to go to town, or take some rest before continuing the descend?");
		System.out.println("1. Go to Town.");
		System.out.println("2. Take some rest.");
		int opt = new Scanner(System.in).nextInt();
		if(opt == 1)
			Town();
		else if(opt == 2)
			Rest();
		else
		if(player.HP < 30)
		{
			System.out.println("You faint from your injuries due to your indecision.");
			Rest();
		}
		else
			System.out.println("You can't make up your mind and as such, go back down the descend.");
		Level1();
	}
	
	private static void clear()
	{
		try
		{
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
		} catch (IOException | InterruptedException ignored) {}
	}
	
	private static void Town()
	{
		Scanner sc = new Scanner(System.in);
		boolean stay = true;
		System.out.println("You reach the town and glance around at the fate of the travellers, and the merchants.");
		System.out.println("Re-enlightened of the fact that the areas around the Descend are very profitable for the merchants.");
		while(stay)
		{
			System.out.println("There are three people who strike your eye, as you glance around the town.");
			System.out.println("1. A swordsman.");
			System.out.println("2. A medic.");
			System.out.println("3. A merchant at his store.");
			System.out.println("Do you wish to approach any one of them?");
			int choice = sc.nextInt();
			if(choice == 1)
			{
				Swordsman();
			}
			else if(choice == 2)
			{
				Medic();
			}
			else if(choice == 3)
			{
				Merchant();
			}
			else
			{
				System.out.println("You lose sight of them, and go back to the entrance of the Descend.");
				stay = false;
			}
		}
		Surface();
	}
	
	private static void Rest()
	{
		Player player = new Player();
		if(player.HP > 0)
		{
			System.out.println("You decide to rest and tend to your wounds.");
			System.out.println("As you see your scars from your battles you wonder whether all of this is really worth the effort.");
//			System.out.println("Day " + day + ": Saved");
			System.out.println("You doze off on a nearby bench ");
			player.HP = Player.HPP;
			System.out.println("...healed.");
//			player.MP = Player.MPP;
//			System.out.println("...mana restored.");
			Surface();
		}
		else
		{
			System.out.println("You wake up on the surface and realise that you managed to claw yourself away from the malice of the Descend.");
			System.out.println("Close call, you almost died.");
			System.out.println("You feel like you're in a better state now.");
			player.HP = Player.HPP;
			System.out.println("Determined to defeat the beast that had you almost slayed.");
			System.out.println("You rush into battle.");
			System.out.println("Health Points : " + player.HP);
			Level1();
		}
	}
	
	private static void Swordsman()
	{
		System.out.println("You approach the swordsman.");
		System.out.println("He seems to have an intimidating air around him.");
		System.out.println("You interact with him only to find out that he doesn't seem to be responding to you.");
		System.out.println("You decide to leave him be, as he ignores you.");
		System.out.println("You go back to where you entered the town from.");
	}
	
	private static void Medic()
	{
		Scanner sc = new Scanner(System.in);
		Player player = new Player();
		
		int purchase, number, shp_cost = 30;
		char healchoice, choice;
		
		System.out.println("You approach the medic who seems to be inviting.");
		System.out.println("He seems to be welcoming and also offers you a nice offer on health potions.");
		System.out.println("The medic seems to have only one variety on health potions right now.");
		System.out.println("> Small Health Potions.\t30 korne.");
		System.out.println("Do you wish to buy Health Potions?");
		healchoice = sc.next().charAt(0);
		if(healchoice == 'y'||healchoice == 'Y')
		{
			System.out.println("Each potion is worth 30 korne.");
			if(player.Money > 30)
			{
				System.out.println("How many do you want to buy?");
				number = sc.nextInt();
				purchase = number*shp_cost;
				if(purchase > player.Money)
				{
					player.Money = player.Money - purchase;
					System.out.println("You have successfully purchased " + number + " small health potions.");
					System.out.println("Balance money in your inventory : " + player.Money);
				}
				else
				{
					System.out.println("You don't seem to have enough money to purchase the health potions.");
					System.out.println("Do you wish to try again? (y/n)");
					choice = sc.next().charAt(0);
					if(choice == 'y'|| choice == 'Y') Medic();
					else
					{
						System.out.println("You choose to head back to where you entered the town from.");
					}
				}
			}
			else
			{
				System.out.println("But, it doesn't seem like you have enough korne to buy any.");
				System.out.println("Maybe sometime in the future.");
				System.out.println("You choose to head back to where you entered the town from.");
			}
		}
	}
	
	private static void Merchant()
	{
		System.out.println("You approach the merchant only to realise that the game developer really should've put more effort into the game.");
		System.out.println("Because, right now, the merchant doesn't even exist.");
	}
	
	private static void replenishEnemy(int enepos)
	{
		Enemy enemy = new Enemy();
		enemy.BattleHP[enepos] = Enemy.HP[enepos];
	}
	
	static class Player
	{
		static int HPP = 100;
		//		int MPP = 70;
		int HP = 100, Atk = 20, Money = 0, numBattles = 0;
		int numOfHealPot = 3;
		String potions = "Small Health Potions";
//		String[] Spells = {"Whirlwind", "Imperial Storm", "Crusher"};
//		int[] SpellDmg = {30, 40, 50};
	
	}
	
	static class Enemy
	{
		static int[] HP = {70, 30, 50};
		int[] BattleHP = {70, 30, 50};
		int[][] Atk = {{12, 13, 15, 14, 16}, {10, 13, 16}, {23, 14, 28}};
		String[][] AtkNames = {{"Dash", "Pound", "Punch", "Throw", "Strike"}, {"Snatch", "Swipe", "Scratch"}, {"Chomp", "Chase", "Bite"}};
		String[] Name = {"Goon", "Rat", "Rapid Dog"};
	}
	
	
}
