package com.aldoivan10.jfxwindow;

public enum JFXTheme
{
    RED("Red","-red-400", "-red-100","-red-200","-red-700"),
    RED_A("Red A","-red-A400", "-red-A100","-red-A200","-red-A700"),
    PINK("Pink","-pink-400", "-pink-100","-pink-200","-pink-700"),
    PINK_A("Pink A","-pink-A400", "-pink-A100","-pink-A200","-pink-A700"),
    PURPLE("Purple","-purple-400", "-purple-100","-purple-200","-purple-700"),
    PURPLE_A("Purple A","-purple-A400", "-purple-A100","-purple-A200","-purple-A700"),
    DEEP_PURPLE("Deep purple","-deep-purple-400", "-deep-purple-100","-deep-purple-200","-deep-purple-700"),
    DEEP_PURPLE_A("Deep purple A","-deep-purple-A400", "-deep-purple-A100","-deep-purple-A200","-deep-purple-A700"),
    BLUE("Blue","-blue-400", "-blue-100","-blue-200","-blue-700"),
    BLUE_A("Blue A","-blue-A400", "-blue-A100","-blue-A200","-blue-A700"),
    LIGHT_BLUE("Light blue","-light-blue-400", "-light-blue-100","-light-blue-200","-light-blue-700"),
    LIGHT_BLUE_A("Light blue A","-light-blue-A400", "-light-blue-A100","-light-blue-A200","-light-blue-A700"),
    CYAN("Cyan","-cyan-400", "-cyan-100","-cyan-200","-cyan-700"),
    CYAN_A("Cyan A","-cyan-A400", "-cyan-A100","-cyan-A200","-cyan-A700"),
    TEAL("Teal","-teal-400", "-teal-100","-teal-200","-teal-700"),
    GREEN("Green","-green-400", "-green-100","-green-200","-green-700"),
    GREEN_A("Green A","-green-A400", "-green-A100","-green-A200","-green-A700"),
    LIGHT_GREEN("Light green","-light-green-400", "-light-green-100","-light-green-200","-light-green-700"),
    AMBER("Amber","-amber-400", "-amber-100","-amber-200","-amber-700"),
    AMBER_A("Amber A","-amber-A400", "-amber-A100","-amber-A200","-amber-A700"),
    ORANGE("Orange","-orange-400", "-orange-100","-orange-200","-orange-700"),
    ORANGE_A("Orange A","-orange-A400", "-orange-A100","-orange-A200","-orange-A700"),
    DEEP_ORANGE("Deep orange","-deep-orange-400", "-deep-orange-100","-deep-orange-200","-deep-orange-700"),
    DEEP_ORANGE_A("Deep orange A","-deep-orange-A400", "-deep-orange-A100","-deep-orange-A200","-deep-orange-A700"),
    BROWN("Brown","-brown-400", "-brown-100","-brown-200","-brown-700"),
    BLUE_GREY("Blue grey","-blue-grey-400", "-blue-grey-100","-blue-grey-200","-blue-grey-700"),
    INDIGO("Indigo","-indigo-400", "-indigo-100","-indigo-200","-indigo-700"),
    INDIGO_A("Indigo A","-indigo-A400", "-indigo-A100","-indigo-A200","-indigo-A700");

    private final String name;
    private final String primary;
    private final String accent;
    private final String light;
    private final String dark;

    JFXTheme(String name,String primary, String accent, String light, String dark)
    {
        this.primary = primary;
        this.accent = accent;
        this.light = light;
        this.dark = dark;
        this.name = name;
    }

    public String primary() { return primary; }

    public String accent() { return accent; }

    public String light() { return light; }

    public String dark() { return dark; }

    public String theme() { return this.name; }

    public String toString()
    {
        return  String.format("-jfx-light-primary-color: %s;" +
                "-jfx-dark-primary-color: %s;" +
                "-jfx-primary-color: %s;" +
                "-fx-accent: %s;", this.light, this.dark, this.primary, this.accent);
    }
}
