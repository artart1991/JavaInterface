package Simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static Simple.Main.*;

//*Ten kod deklaruje statyczną klasę o nazwie Wall, która implementuje interfejsy Structure i CompositeBlock.
class Wall implements Structure, CompositeBlock {

    //* Deklaruje prywatne pole o nazwie blocks w klasie, reprezentujące listę elementów typu Block
    private List<Block> blocks;

    //*Ten kod definiuje konstruktor dla klasy o nazwie Wall. Wewnątrz konstruktora inicjalizuje
    // prywatne pole blocks z nową instancją ArrayList,
    // tworząc pustą listę do zarządzania elementami Block
    public Wall() {
        this.blocks = new ArrayList<>();
    }

    //*Ta metoda zwraca rozmiar prywatnego pola blocks, które jest listą ArrayList.
    // Podaje ona liczbę elementów (typu Block) aktualnie przechowywanych na liście
    @Override
    public int count() {
        return blocks.size();
    }

    //*Ta metoda wykorzystuje stream Java do filtrowania elementów w polu blocks na podstawie określonego materiału.
    // Odfiltrowane bloki są zbierane w nową listę i zwracane
    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream().filter(block -> material.equals(block.getMaterial())).toList();

    }

    //*Ta metoda wykorzystuje stream Java do filtrowania elementów w polu blocks na podstawie określonego koloru.
    // Znajduje i zwraca pierwszy block w określonym kolorze
    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream().filter(block -> color.equals(block.getColor())).findFirst();
    }


    //*Ta metoda zwraca prywatne pole blocks, które jest listą elementów Block
    @Override
    public List<Block> getBlocks() {
        return blocks;
    }


    //*Ta metoda zwraca stały ciąg znaków "WallCollors", zapewniając stałą wartość koloru
    @Override
    public String getColor() {
        return "WallCollors";
    }

    //* Ta metoda zwraca stały ciąg znaków "WallMaterials", zapewniając stałą wartość materiału
    @Override
    public String getMaterial() {
        return "WallMaterials";
    }


    //*Metoda generuje reprezentację łańcuchową. Łączy ona nazwę klasy ("Wall") z informacjami o kolorze i materiale uzyskanymi z metod getColor i getMaterial,
    // tworząc zwięzłe podsumowanie atrybutów obiektu.
    @Override
    public String toString() {
        return "Wall - Color: " + getColor() + ", Material: " + getMaterial();
    }
}
