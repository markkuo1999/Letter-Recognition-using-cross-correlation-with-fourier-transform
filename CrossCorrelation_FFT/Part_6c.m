Scene = imread('./Scene.bmp');
Letter_e = imread('./letter_e.bmp');
Scene = rgb2gray(Scene);
Letter_e = rgb2gray(Letter_e);

crr = xcorr2(Scene, Letter_e);
imshow(Scene);
hold on;
for i = 1:1076
    for j = 1:1076
        if crr(j,i) > 55000000%threshold value%
            rectangle('Position',[i-52,j-52,53,61],'Edgecolor', 'r');
        end  
        if crr(j,i) < 55000000
        end   
    end
end  
