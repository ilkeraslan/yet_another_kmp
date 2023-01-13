//
//  ContentView.swift
//  ios
//
//  Created by Ilker Aslan on 04/12/22.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack(alignment: .leading) {
            Text("Hello, world!")
                .font(.title)
                .foregroundColor(.cyan)
                .padding(.bottom)
            
            HStack {
                Text("This is your long subtitle which will be rendered in more lines with some other lines!")
                    .font(.subheadline)
                    .foregroundColor(.black)
                
                Text("And here is a trailing text.")
                    .font(.subheadline)
                    .foregroundColor(.black)
            }
        }
        .padding()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
