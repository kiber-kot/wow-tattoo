package art.tattoo.wowtattoo.attributes;

public enum Styles {
    Etching("Гравюра"),
    Bioorganics("Био-органика"),
    Minimalism("Минимализм"),
    ThumbnailImage("Миниатюра"),
    Linework("Лайнворк");


    private String style;

    Styles(String style){
        this.style = style;
    }

    @Override
    public String toString() {
        return style;
    }
}

