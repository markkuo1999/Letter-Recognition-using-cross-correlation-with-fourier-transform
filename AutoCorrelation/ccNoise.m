Scene = imread('./Scene.bmp');
Scene = rgb2gray(Scene);

img = zeros(1024,1024);
%img = rgb2gray(img);
for i = 1:1024
    for j = 1:1024
        img(j,i) = randi([-255, 255]);
    end    
end
imshow(img);
A = autocorr2d(img);
