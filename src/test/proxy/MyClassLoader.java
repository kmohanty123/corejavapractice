package test.proxy;

import java.io.SerializablePermission;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.AccessControlContext;
import java.security.Permissions;
import java.security.ProtectionDomain;



public class MyClassLoader extends URLClassLoader{
	
	public MyClassLoader(URL[] urls) {
		super(urls);
		// TODO Auto-generated constructor stub
	}

	static final SerializablePermission SUBSTITUTION_PERMISSION =
            new SerializablePermission("enableSubstitution");
	
	/*MyClassLoader(String name, URL[] urls, ClassLoader parent,
            AccessControlContext acc) {
		 super(urls,acc);
		
		}
	
	 static AccessControlContext createPermAccCtxt(final String... permNames) {
	        final Permissions perms = new Permissions();
	        for (final String permName : permNames) {
	            perms.add(new RuntimePermission(permName));
	        }
	        return new AccessControlContext(
	        		new ProtectionDomain[] { new ProtectionDomain(null, perms) });
	    }*/
	
       protected Class<?> findClass(final String name)
		        throws ClassNotFoundException
		    {
		SecurityManager sm = System.getSecurityManager();
		sm.checkPermission(SUBSTITUTION_PERMISSION);
		return super.findClass(name);
	 }
	

}
