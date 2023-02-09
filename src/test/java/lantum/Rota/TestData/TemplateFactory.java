package lantum.Rota.TestData;

import lantum.Rota.Model.Template;

public class TemplateFactory {
    public static Template DefaultRollingTemplate() {
        return new Template(
                "AutoTest " + Math.random(),
                "Core shifts - Emergency Department",
                "Rolling rota",
                "Cons.",
                1
        );
    }
}

