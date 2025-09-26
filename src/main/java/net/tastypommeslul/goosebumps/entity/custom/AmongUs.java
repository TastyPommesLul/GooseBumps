package net.tastypommeslul.goosebumps.entity.custom;

import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.tastypommeslul.goosebumps.entity.ModEntities;
import org.jetbrains.annotations.Nullable;

public class AmongUs extends AnimalEntity {
    public static class AmongUsEntityRenderState extends LivingEntityRenderState {
        public static final AnimationState walkingAnim = new AnimationState();
        public static int walkingAnimTimeout = 0;
    }
    public AmongUs(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new WanderAroundGoal(this, 5));
//        this.goalSelector.add(1, new LookAtEntityGoal(this, PlayerEntity.class, 8f));
//        this.goalSelector.add(2, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 20.0)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.25)
                .add(EntityAttributes.ATTACK_DAMAGE, 0.5);
    }

    private void setupAnimStates() {
        if (AmongUsEntityRenderState.walkingAnimTimeout <= 0) {
            AmongUsEntityRenderState.walkingAnimTimeout = 20;
            AmongUsEntityRenderState.walkingAnim.start(this.age);
        } else {
            --AmongUsEntityRenderState.walkingAnimTimeout;
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
            this.setupAnimStates();
        }
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return false;
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.AMONG_US.create(world, SpawnReason.BREEDING);
    }
}
