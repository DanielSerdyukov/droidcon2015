package moscow.droidcon2015.processor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

/**
 * @author Daniel Serdyukov
 */
@SupportedAnnotationTypes({"moscow.droidcon2015.processor.BindView"})
public class DroidConProcessor extends AbstractProcessor {

    private final Map<TypeElement, BindViewVisitor> mVisitors = new HashMap<>();

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (annotations.isEmpty()) {
            return false;
        }

        final Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(BindView.class);
        for (final Element element : elements) {
            final TypeElement object = (TypeElement) element.getEnclosingElement();
            BindViewVisitor visitor = mVisitors.get(object);
            if (visitor == null) {
                visitor = new BindViewVisitor(processingEnv, object);
                mVisitors.put(object, visitor);
            }
            element.accept(visitor, null);
        }

        for (final BindViewVisitor visitor : mVisitors.values()) {
            visitor.brewJava();
        }

        return true;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

}
