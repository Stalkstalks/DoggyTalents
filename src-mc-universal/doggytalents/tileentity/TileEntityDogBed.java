package doggytalents.tileentity;

import java.util.List;

import doggytalents.base.ObjectLib;
import doggytalents.entity.EntityDog;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

/**
 * @author ProPercivalalb
 */
public abstract class TileEntityDogBed extends TileEntity implements ITickable {

	private String casingId;
	private String beddingId;
	
	public TileEntityDogBed() {
		this.casingId = "";
		this.beddingId = "";
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		this.casingId = tag.getString("casingId");
		this.beddingId = tag.getString("beddingId");
    }

    public NBTTagCompound writeToNBTGENERAL(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setString("casingId", this.casingId);
		tag.setString("beddingId", this.beddingId);
		return tag;
	}
	
	@Override
	public void update() {
		List dogs =  ObjectLib.BRIDGE.getEntitiesWithinAABB(this.world, ObjectLib.ENTITY_DOG_CLASS, this.pos.getX(), this.pos.getY(), this.pos.getZ(), 3, 2, 3);
		 
	    if (dogs != null && dogs.size() > 0) {
	    	for (int index = 0; index < dogs.size(); index++) {
	            EntityDog dog = (EntityDog)dogs.get(index);
	            
	            if(dog.getMaxHealth() / 2 >= dog.getHealth()) {
	            	//if(dog.bedHealTick <= 0) {
	            		dog.heal(0.5F);
	            		//dog.bedHealTick = 20 * 20;
	            	//}
	            	//dog.bedHealTick--;
        		}
	        }
	    }

	}

	public void setCasingId(String newId) {
		this.casingId = newId;
	}
	
	public void setBeddingId(String newId) {
		this.beddingId = newId;
	}
	
	public String getCasingId() {
		return this.casingId;
	}
	
	public String getBeddingId() {
		return this.beddingId;
	}
}
