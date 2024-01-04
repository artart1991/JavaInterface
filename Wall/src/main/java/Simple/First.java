package Simple;

import java.util.List;
import java.util.Optional;

class Main {
    interface Structure {
        Optional<Block> findBlockByColor(String color);
        List<Block> findBlocksByMaterial(String material);
        int count();
    }

    interface Block {
        String getColor();
        String getMaterial();

        @Override
        String toString();
    }

    interface CompositeBlock extends Block {
        List<Block> getBlocks();

        @Override
        String toString();
    }


    public static void main(String[] args) {


        //*Tworzymy kilka przykładowych bloków
        Block block1 = new Block() {
            @Override
            public String getColor() {
                return "Red";
            }

            @Override
            public String getMaterial() {
                return "Wood";
            }
            @Override
            public String toString() {
                return "Block - Color: " + getColor() + ", Material: " + getMaterial();
            }
        };


        Block block2 = new Block() {
            @Override
            public String getColor() {
                return "Blue";
            }

            @Override
            public String getMaterial() {
                return "Brick";
            }

            @Override
            public String toString() {
                return "Block - Color: " + getColor() + ", Material: " + getMaterial();
            }
        };

        Block block3 = new Block() {
            @Override
            public String getColor() {
                return "Black";
            }

            @Override
            public String getMaterial() {
                return "Wood";
            }
            @Override
            public String toString() {
                return "Block - Color: " + getColor() + ", Material: " + getMaterial();
                }
            };

        // *Instancja klasy ConcreteCompositeBlock, implementująca interfejs CompositeBlock,
        // jest tworzona z listą zawierającą block1 i block3

        CompositeBlock compositeBlock1 = new ConcreteCompositeBlock(List.of(block1, block3));

        // *Instancja klasy Wall jest tworzona i przypisywana do zmiennej wall przy użyciu domyślnego konstruktora
        Wall wall = new Wall();

        // *Ten fragment kodu uzyskuje dostęp do listy bloków należących do obiektu
        // all o nazwie wall i dodaje do niej obiekt block1, block2, block3, compositeBlock1
        wall.getBlocks().add(block1);
        wall.getBlocks().add(block2);
        wall.getBlocks().add(block3);
        wall.getBlocks().add(compositeBlock1);

        // Drukowanie informacji o Wall i jej blokach
        System.out.println(wall);
        System.out.println("Total blocks in the wall: " + wall.count());
        System.out.println("Blocks with material Wood in the wall: " + wall.findBlocksByMaterial("Wood"));
        System.out.println("Block with color Red in the wall: " + wall.findBlockByColor("Red").orElse(null));
    }
}
