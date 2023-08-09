package com.gildedrose;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.myPackage.Item;

class GildedRose {
	/*
	 * Item[] items;
	 * 
	 * public GildedRose(Item[] items) { this.items = items; }
	 */
	List<Item> items;

    public GildedRose(List<Item> items) {
      this.items = items;
    }
    
    List<Item> mylist = items;

    public void updateQuality() {
  	
    	
    	for(Item items:mylist)
		{
			if(items.name != "Sulfuras, Hand of Ragnaros")
				items.sellIn = items.sellIn - 1;
		}    	
    	
    	//Aged Brie
    	List<Item> mylist1 =mylist.stream().filter(i -> i.name == "Aged Brie")
    									   .filter(j-> j.quality < 50)
    									   .collect(Collectors.toList());

    			for(Item items:mylist1)
    			{	
    				items.quality = items.quality + 1;
    				//System.out.println("Item-" + items.name +" "+"sellIn-"+items.sellIn+" "+"Quality-"+ items.quality);
    			}
    			
    	//Backstage passes to a TAFKAL80ETC concert
    	List<Item> mylist2 =mylist.stream().filter(i -> i.name == "Backstage passes to a TAFKAL80ETC concert")
    									   .filter(j-> j.quality < 50)
    									   .collect(Collectors.toList());
    			for(Item items:mylist2)
    			{	
    				items.quality = items.quality + 1;
    				if(items.sellIn < 11)
    					items.quality = items.quality + 1;
    				if(items.sellIn < 6)
    					items.quality = items.quality + 1;
    				if(items.sellIn < 0)
    					items.quality = 0;				
    				
    				//System.out.println("Item-" + items.name +" "+"sellIn-"+items.sellIn+" "+"Quality-"+ items.quality);
    			}
    			
    	// All other Items
    	List<Item> mylist3 =mylist.stream().filter(i -> (i.name != "Aged Brie") && (i.name != "Backstage passes to a TAFKAL80ETC concert") 
    					 && (i.name != "Sulfuras, Hand of Ragnaros") && (i.name != "Conjured Mana Cake")) 
    					 						    .filter(j-> j.quality > 0) //
    					 						    .collect(Collectors.toList());
    			 for(Item items:mylist3) { 
    				 items.quality = items.quality - 1; 
    				 if(items.sellIn <= 0 && items.quality > 0)
    						items.quality = items.quality - 2;	
    				// System.out.println("Item-" + items.name +" "+"sellIn-"+items.sellIn+" "+"Quality-"+ items.quality); 
    			}
    			 
    	 // Conjured Cake
    	 List<Item> mylist4 =mylist.stream().filter(i -> i.name == "Conjured Mana Cake") 
    					 						    .filter(j-> j.quality > 0) //
    					 						    .collect(Collectors.toList());
    			 for(Item items:mylist4) { 
    				 items.quality = items.quality - 2; 
    				 if(items.sellIn <= 0 && items.quality > 0)
    						items.quality = items.quality - 2;	
    				// System.out.println("Item-" + items.name +" "+"sellIn-"+items.sellIn+" "+"Quality-"+ items.quality); 
    			}	
    			 
    	 for(Item items:mylist)
    	 {
    		System.out.println("Item::" + items.name +" "+"sellIn::"+items.sellIn+" "+"Quality::"+ items.quality);
    	 }
        
}