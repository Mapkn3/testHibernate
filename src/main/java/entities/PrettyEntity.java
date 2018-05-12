package entities;

import java.lang.reflect.Field;

public abstract class PrettyEntity {
    public abstract long primaryKey();

    @Override
    public String toString() {
        String result = "";
        try {
            Field name = this.getClass().getDeclaredField("name");
            name.setAccessible(true);
            result = name.get(this).toString();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
        /*Class entity = this.getClass();
        final StringBuffer sb = new StringBuffer(entity.getSimpleName());
        sb.append(" {\n");
        try {
            for (Field field : entity.getDeclaredFields()) {
                field.setAccessible(true);
                sb.append("    ").append(field.getName()).append(": ").append(field.get(this)).append("\n");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        sb.append("}\n");
        return sb.toString();*/
    }
}
