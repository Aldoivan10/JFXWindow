package com.aldoivan10.jfxwindow;

public enum JFXTheme
{
    RED("Red","-red-600", "-red-200","-red-400","-red-700"),
    PINK("Pink","-pink-600", "-pink-200","-pink-400","-pink-700"),
    PURPLE("Purple","-purple-600", "-purple-200","-purple-400","-purple-700"),
    DEEP_PURPLE("Deep purple","-deep-purple-600", "-deep-purple-200","-deep-purple-400","-deep-purple-700"),
    DEEP_PURPLE_A("Deep purple A","-deep-purple-A400", "-deep-purple-A100","-deep-purple-A200","-deep-purple-A700"),
    BLUE("Blue","-blue-600", "-blue-200","-blue-400","-blue-700"),
    BLUE_A("Blue A","-blue-A400", "-blue-A100","-blue-A200","-blue-A700"),
    LIGHT_BLUE("Light blue","-light-blue-600", "-light-blue-200","-light-blue-400","-light-blue-700"),
    LIGHT_BLUE_A("Light blue A","-light-blue-A400", "-light-blue-A100","-light-blue-A200","-light-blue-A700"),
    CYAN("Cyan","-cyan-600", "-cyan-200","-cyan-400","-cyan-700"),
    TEAL("Teal","-teal-600", "-teal-200","-teal-400","-teal-700"),
    GREEN("Green","-green-600", "-green-200","-green-400","-green-700"),
    GREEN_A("Green A","-green-A400", "-green-A100","-green-A200","-green-A700"),
    LIGHT_GREEN("Light green","-light-green-600", "-light-green-200","-light-green-400","-light-green-700"),
    AMBER("Amber","-amber-600", "-amber-200","-amber-400","-amber-700"),
    AMBER_A("Amber A","-amber-A400", "-amber-A100","-amber-A200","-amber-A700"),
    ORANGE("Orange","-orange-600", "-orange-200","-orange-400","-orange-700"),
    ORANGE_A("Orange A","-orange-A400", "-orange-A100","-orange-A200","-orange-A700"),
    DEEP_ORANGE("Deep orange","-deep-orange-600", "-deep-orange-200","-deep-orange-400","-deep-orange-700"),
    DEEP_ORANGE_A("Deep orange A","-deep-orange-A400", "-deep-orange-A100","-deep-orange-A200","-deep-orange-A700"),
    BROWN("Brown","-brown-600", "-brown-200","-brown-400","-brown-700"),
    BLUE_GREY("Blue grey","-blue-grey-600", "-blue-grey-200","-blue-grey-400","-blue-grey-700"),
    INDIGO("Indigo","-indigo-600", "-indigo-200","-indigo-400","-indigo-700"),
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
