package ru.kowkodivka.tool.menu;

import arc.func.Cons;
import mindustry.gen.Player;

public interface IMenuBuilder {
    IMenuBuilder id(String id);

    IMenuBuilder title(String title);

    IMenuBuilder content(String content);

    IMenuBuilder button(String name, Cons<Player> runner);
}
