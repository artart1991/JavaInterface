package Simple;

import java.util.List;

import static Simple.Main.*;

class ConcreteCompositeBlock implements CompositeBlock {
private List<Block> blocks;

public ConcreteCompositeBlock(List<Block> blocks) {
        this.blocks = blocks;
        }

@Override
public List<Block> getBlocks() {
        return blocks;
        }

@Override
public String getColor() {
        return "CompositeBlockColor";
        }

@Override
public String getMaterial() {
        return "CompositeBlockMaterial";
        }

@Override
public String toString() {
        return "ConcreteCompositeBlock - Color: " + getColor() + ", Material: " + getMaterial();
        }
        }