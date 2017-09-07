package ezdi.app;

import java.lang.reflect.Field;

import ezdi.model.Model;
import javafx.util.Callback;

public class ModelInjector implements Callback<Class<?>, Object> {
	
	private final Model model ;
	
	public ModelInjector(Model model) {
		this.model = model ;
	}

	@Override
	public Object call(Class<?> type) {
		
		try {
			Object controller = type.newInstance();
			for (Field f : type.getDeclaredFields()) {
				if (f.getType() == Model.class) {
					boolean accessible = f.isAccessible() ;
					if (! accessible) {
						f.setAccessible(true);
					}
					f.set(controller, model);
					if (! accessible) {
						f.setAccessible(false);
					}
				}
			}
			return controller ;
		} catch (Exception exc) {
			throw new RuntimeException(exc);
		}
		
	}
	
}