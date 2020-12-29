Scene = imread('./Scene.bmp');
Letter_o= imread('./letter_o.bmp');
Scene = rgb2gray(Scene);
Letter_o = rgb2gray(Letter_o);

tic
crr = xcorr2_fft(Scene,Letter_o);
toc
imshow(crr);%2D image%
imshow(Scene);
hold on;
for i = 1:1076
    for j = 1:1076
        if crr(j,i) > 56600000%threshold value%
            rectangle('Position',[i-52,j-52,53,61],'Edgecolor', 'r');
        end  
        if crr(j,i) < 56600000
        end   
    end
end   
%Examination on the outputs: 'o' needs bigger threshold than 'e' character
%to be detected. I think that the reason is that 'o' character has bigger
%similarity with other words, and 'e' is relatively distinguishable.