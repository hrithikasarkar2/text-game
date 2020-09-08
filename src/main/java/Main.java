import java.io.*;
import java.util.Scanner;
import java.util.Random;

class textgame
{
    public static void main(String args[])throws IOException
  {
    BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
    //System objects

        Random rand = new Random();
        
        //Game variables
        String[] enemies = { "Skeleton","Zombie","Warrior","Assassin"};
        int maxEnemyHealth = 75;
        int  enemyAttackDamage = 25;
        
        //Player variables
        int health =100;
        int attackDamage =50;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthpotionDropChance = 50; //Percentage
        
        boolean running = true;
        System.out.println("Welcome to the Dungeon!");
               
        GAME:
        while(running){
            System.out.println("----------------------------------------------------------------------------------------");
            
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t#"+enemy+" has appeared ! #\n");
            
            while(enemyHealth>1)
            {
                System.out.println("\t");
                System.out.println("\t Your HP:"+health);
                System.out.println("\t"+enemy+"'s HP:"+enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink Health potion");
                System.out.println("\t3. Run!");
                String input=in.readLine();
                if(input.equals("1"))
                {
                    int damageDealt=rand.nextInt(attackDamage);
                    int damageTaken =rand.nextInt(enemyAttackDamage);
                    
                    
                   enemyHealth-=damageDealt;
                   health-= damageTaken;
                   
                   System.out.println("\t>You strike the "+ enemy+" "+"for"+damageDealt+" "+"damage");
                   System.out.println("\t. You receive "+damageTaken+"in retaliation");
                   
                   if(health<1)
                   {
                       System.out.println("\t> You have taken too much damage!!");
                       break;
                   }
                   
                }   
            
                
                else if(input.equals("2"))
                {
                    if(numHealthPotions>0)
                    {
                        health+=healthPotionHealAmount;
                        numHealthPotions--;
                        System.out.println("\t> You drink a health potion ,healing yourself for"+healthPotionHealAmount+"."+"\n\t>You now have "+health+" "+"HP."+"\n\t>You have"+numHealthPotions+"health potions left.\n");
                    }
                    else
                    {
                        System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get one!");
                    }
                }
                else if(input.equals("3"))
                {
                    System.out.println("\t You run away from "+enemy+" !");
                    continue GAME;
                }
                else
                {
                    System.out.println("\t Invalid command");
                    
                }  
            }
            if(health<1)
            {
                System.out.println("You limp out of the dungeon,Try again!!!");
                break;
            }
            
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            System.out.println(" # " +enemy + "was defeated!#");
            System.out.println(" # You have"+health+"HP left .#");
            if(rand.nextInt(100)<healthpotionDropChance)
            {
                numHealthPotions++;
                System.out.println(" # The "+ enemy +"dropped a health potion! #");
                System.out.println(" # You now have "+numHealthPotions+"health potion(s). #");
                
            }
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            System.out.println(" What would you like to do now?");
            System.out.println(" 1. Continue fighting");
            System.out.println(" 2. Exit dungeon");
            
            String input = in.readLine();
            
            while(!input.equals("1")&&!input.equals("2"))
            {
                System.out.println("Invalid command");
                input = in.readLine();
            }
            if(input.equals("1"))
            {
                System.out.println("You continue on your adventure !");
            }
            else if(input.equals("2"))
            {
                System.out.println("You exit the dungeon,come back soon!!");
                break;
            }
        }
        
        System.out.println("############################");
        System.out.println("THANKS FOR PLAYING ! #");
        System.out.println("############################");
  }
}
