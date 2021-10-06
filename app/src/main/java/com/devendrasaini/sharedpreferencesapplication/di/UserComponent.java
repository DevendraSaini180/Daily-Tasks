package com.devendrasaini.sharedpreferencesapplication.di;

import com.devendrasaini.sharedpreferencesapplication.MainActivity;
import com.devendrasaini.sharedpreferencesapplication.rest.PostApiClient;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = PostApiClient.class)
/*The module attribute in @Component annotation tells the Dagger what module to include
* when building the graph for providing dependencies */
public interface UserComponent {

    /*
    The inject method is used to tell Dagger that MainActivity wants to access DAG(Directed Acyclic Graph)
    and Dagger should provide all Dependencies that the MainActivity request.
     */
    void inject(MainActivity mainActivity);


    @Component.Builder
    interface Builder {

        /* @BindsInstance marks a method on a component builder or a parameter on a component factory as
        * binding an instance to some key within the component*/
        @BindsInstance
        Builder firstName(@Named("firstName") String firstName);
        /*Dagger does not know which string is firstName and which is lastName so to resolve this problem
        * we use @Named annotation*/

        @BindsInstance
        Builder lastName(@Named("lastName")String lastName);

        /*Whenever we create Builder interface we have to create a method that returns the component
        * (UserComponent here) */
        UserComponent build();
    }
}
