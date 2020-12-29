Scene = imread('./Scene.bmp');
Letter_e = imread('./letter_e.bmp');
Scene = rgb2gray(Scene);
Letter_e = rgb2gray(Letter_e);

tic
crr = xcorr2_fft(Scene,Letter_e);
toc
imshow(crr);%2D image%
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
%crr image compare with Part_6a.m: The same as Part_6a.m.%
%differences or similarities with Part_6c.m:The Scene image are the same as Part_6c.m. The computation time is different.%
