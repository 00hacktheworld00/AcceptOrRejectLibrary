This library can be used as Incoming Call/Video Screen widget with customizable icons, background, etc.
The functions to change images and backgrounds are very simple.

    int image;

    private void setCircularBackGreenImage(image);
    
    private void setCircularBackRedImage(image);

    private void setIconGreenImage(image);

    private void setIconRegImage(image);

    private void setOvalRectangleBoxImage(image);


Include <AcceptOrReject in XML>

Then in JAVA,
        ImageTouchSlider slider = (ImageTouchSlider) findViewById(R.id.slider);

        slider.setOnImageSliderChangedListener(new ImageTouchSlider.OnImageSliderChangedListener() {
            @Override
            public void onChanged() {
                // do something what you want here.
            }
        });

        slider.setOnImageClickListener(new ImageTouchSlider.OnImageClickListener() {
            @Override
            public void onClickChanged() {
                // do something what you want here.
            }
        });


LIBRARY OUTPUT SCREENSHOT:-
![DEMO](https://s15.postimg.org/53zl1da0r/image.jpg)




DEMO SCREEN USING THIS LIBRARY SCREENSHOT:-
![DEMO SCREEN USING THIS LIBRARY](https://s11.postimg.org/5e2i75mf7/layout_2016_12_07_123459.png)



<div>Icons made by <a href="http://www.flaticon.com/authors/zurb" title="Zurb">Zurb</a> from <a href="http://www.flaticon.com" title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a></div>


<div>Icons made by <a href="http://www.freepik.com" title="Freepik">Freepik</a> from <a href="http://www.flaticon.com" title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a></div>
