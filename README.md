# BindingRecyclerView

BindingRecyclerView is a RecyclerView implementation which integrates with the android data binding library and does not need any exlicit implementation of the adapter. It can be configurred from xml view declaration.

### Usage example

Declare the BindingRecycleView as the following

    <?xml version="1.0" encoding="utf-8"?>
    <layout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto">

        <data>
            <variable
                name="viewModel"
                type="com.samvel1024.databindingrv_sample.MainViewModel" />
        </data>


        <android.support.design.widget.CoordinatorLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:fitsSystemWindows="true">

            <com.samvel1024.databindingrv.BindingRecyclerView
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_margin="1dp"
                app:bindingVarPath="com.samvel1024.databindingrv_sample.BR.viewModel"
                app:itemLayoutResId="@layout/list_item"
                app:layoutManager="LinearLayoutManager"
                app:viewModelList="@{viewModel.itemViewModels}" />


            <android.support.design.widget.FloatingActionButton
                android:id="@+id/fab"
                android:onClick="@{() -> viewModel.onAddItemClicked()}"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="bottom|end"
                android:layout_margin="10dp"
                android:src="@drawable/ic_playlist_add_black_18dp" />

        </android.support.design.widget.CoordinatorLayout>
    </layout>

If applying the MVVM pattern, create a view model for handling the recycle view logic, like add, remove item or fetch from an API.

    public class MainViewModel extends BaseObservable {

        private List<ListItemViewModel> viewModels;

        public MainViewModel() {
            viewModels = new ArrayList<>(Arrays.asList(
                    new ListItemViewModel("Toyota Camry", "34000$"),
                    new ListItemViewModel("Honda Civic", "32000$"),
                    new ListItemViewModel("BMW M3", "85000$"),
                    new ListItemViewModel("Volkswagen Golf", "40000$")
            ));
        }

        @Bindable
        public List<ListItemViewModel> getItemViewModels() {
            return viewModels;
        }

        public void onAddItemClicked() {
            viewModels.add(new ListItemViewModel("A new car", "80000$"));
            notifyPropertyChanged(BR.itemViewModels);
        }

    }

Create corresponding xml and view model view declaration for the recycle view item

    <layout>

        <data>

            <variable
                name="viewModel"
                type="com.samvel1024.databindingrv_sample.ListItemViewModel" />
        </data>

        <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical">

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@{viewModel.name}" />

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@{viewModel.price}" />

            <Button
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:onClick="@{() -> viewModel.onBuyButtonClicked()}"
                android:text="Buy" />

        </LinearLayout>
    </layout>

Item view model

    public class ListItemViewModel {

        private final String name;
        private final String price;

        public ListItemViewModel(String name, String price) {
            this.name = name;
            this.price = price;
        }

        public void onBuyButtonClicked() {
            Log.d("ListItemViewModel", "Buying " + name + " for " + price);
        }

        public String getName() {
            return name;
        }

        public String getPrice() {
            return price;
        }
    }

Now create the MainViewModel class and bind it to the view

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
            binding.setViewModel(new MainViewModel());
        }

### Configuring BindingRecyclerView

There are 3 required arguemnts to have in the xml declaration

- ###### bindingVarPath

  This shuold be the name of the BR class + '.' + list item view model variable name. For example if list item xml accepts variable with name `myViewModel` and the `BR` class name is `com.mycompany.myapp.BR`the `bindingVarPath` attribute should be `app:bindingVarPath="com.mycompany.myapp.BR.myViewModel"`

- ###### itemLayoutResId

  The list item layout resource reference, i.e `app:itemlayoutResId="@layout/list_item"`

- ###### viewModelList

  This attribute is going to be set by the data binding library by invoking `BindingRecyclerView.setViewModelList` This should be a reference to a variable or getter which returns list of view models per each recycler view row. The type of the list should exactly match the type of the variable specified in `bindingVarPath`.
